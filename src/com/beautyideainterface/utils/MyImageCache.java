package com.beautyideainterface.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

import android.R.array;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap.CompressFormat;
import android.os.Environment;
import android.util.Log;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader.ImageCache;

public class MyImageCache implements ImageCache {

	private LruCache<String, Bitmap>lruchaCache;
	SoftReference<Bitmap>softReference  =new SoftReference<Bitmap>(null);
	HashMap<String, SoftReference<Bitmap>> hashMap =new HashMap<String, SoftReference<Bitmap>>();
	static Context context;
	
	private static MyImageCache imageCache;
	public static MyImageCache Instance(Context context){
		
		if(imageCache==null)
		{
		   imageCache = new MyImageCache();
		}
		imageCache.context =context;
		return imageCache;	
	}
	private MyImageCache(){
		int max=(int) (Runtime.getRuntime().maxMemory()/8);
		lruchaCache = new LruCache<String, Bitmap>(max){

			@Override
			protected int sizeOf(String key, Bitmap value) {
				
				
				return value.getRowBytes()*value.getHeight();
			}
			@Override
			protected void entryRemoved(boolean evicted, String key,
					Bitmap oldValue, Bitmap newValue) {
				if(evicted)
				{
					 	SoftReference<Bitmap> temp = new SoftReference<Bitmap>(oldValue);
					 	hashMap.put(key, temp);
				}
				super.entryRemoved(evicted, key, oldValue, newValue);
		}
	};
	}
	@Override
	public Bitmap getBitmap(String url) {
		Bitmap bitmap=null;
		// 1 lruCache
		bitmap= lruchaCache.get(url);
		if(bitmap!=null)
		{
			return bitmap;
		}
		// 2 softRefrence ������
		softReference =hashMap.get(url);
			if(softReference!=null)
			{
				bitmap =softReference.get();
				if(bitmap!=null)
				{
					lruchaCache.put(url, bitmap);
					return bitmap;
				}
			}
		// 3 ���ػ���
			File file  = getFile(context,url);
			
			if(file!=null&&file.exists())
			{
				bitmap = BitmapFactory.decodeFile(file.getPath());
				//Log.i("Path", file.getPath());
				lruchaCache.put(url, bitmap);			
				return bitmap;
			}
		return null;
	}
	public File getFilePath(Context context){
		File file = null;
		if (Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED)) {
			// /mnt/sdcard/android/data/����/cache
			file = context.getExternalCacheDir();
		}

		else {
			// data/data/����/cache
			file = context.getCacheDir();
		}
		
		return file;	
	}
	private File getFile(Context context,String url) {
		File file = getFilePath(context);
		String[] splite = url.split("/");
		String name = splite[splite.length - 1];
		return new File(file, name);
	}
	@Override
	public void putBitmap(String url, Bitmap bitmap) {
			//lruchache
			lruchaCache.put(url, bitmap);
			//�Ƿ�ɾ��֮ǰ�ļ��Ĵ�С
			deleteCacheFile(context);
			//���ػ���
			File imageFile =getFile(context, url);
			try {
				FileOutputStream fos = new FileOutputStream(imageFile);
				bitmap.compress(Bitmap.CompressFormat.PNG,100, fos);
				fos.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	private void deleteCacheFile(Context context) {
		//�����������ļ��� ��С
		int length = 0;
			File file = getFilePath(context);
			File []filelist = file.listFiles();
			for(int i =0;i<filelist.length;i++)
			{
				length+=filelist[i].length();
			}
		//�ж��Ƿ񳬳�10M
			if(length>=10*1024*1024)
			{
				//�����  ��ɾ�����֮һ���ļ�
				Arrays.sort(filelist, new Comparator<File>() {

					@Override
					public int compare(File lhs, File rhs) {
						return (int) (lhs.lastModified()-rhs.lastModified());
					}
				});
				for(int i=0;i<filelist.length/3;i++)
				{
					filelist[i].delete();
				}
			}
				
	}

}
