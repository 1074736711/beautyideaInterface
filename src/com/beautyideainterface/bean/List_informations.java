package com.beautyideainterface.bean;

public class List_informations {
	
	@Override
	public String toString() {
		return "List_informations [rsId=" + rsId + ", modules=" + modules.toString()
				+ ", title=" + title + ", link=" + link + ", thumbnail="
				+ thumbnail + ", thumbnailV2=" + thumbnailV2 + ", duration="
				+ duration + ", published=" + published + ", uptime=" + uptime
				+ ", player=" + player + ", streamtypes=" + streamtypes
				+ ", flag=" + flag + ", viewCount=" + viewCount
				+ ", favoriteCount=" + favoriteCount + ", upcount=" + upcount
				+ ", downcount=" + downcount + ", commentcount=" + commentcount
				+ ", tag=" + tag + "]";
	}
	public String getRsId() {
		return rsId;
	}
	public void setRsId(String rsId) {
		this.rsId = rsId;
	}
	public Modules getModules() {
		return modules;
	}
	public void setModules(Modules modules) {
		this.modules = modules;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getThumbnailV2() {
		return thumbnailV2;
	}
	public void setThumbnailv2(String thumbnailV2) {
		this.thumbnailV2 = thumbnailV2;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getPublished() {
		return published;
	}
	public void setPublished(String published) {
		this.published = published;
	}
	public String getUptime() {
		return uptime;
	}
	public void setUptime(String uptime) {
		this.uptime = uptime;
	}
	public String getPlayer() {
		return player;
	}
	public void setPlayer(String player) {
		this.player = player;
	}
	public String getStreamtypes() {
		return streamtypes;
	}
	public void setStreamtypes(String streamtypes) {
		this.streamtypes = streamtypes;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public int getFavoriteCount() {
		return favoriteCount;
	}
	public void setFavoriteCount(int favoriteCount) {
		this.favoriteCount = favoriteCount;
	}
	public int getUpcount() {
		return upcount;
	}
	public void setUpcount(int upcount) {
		this.upcount = upcount;
	}
	public int getDowncount() {
		return downcount;
	}
	public void setDowncount(int downcount) {
		this.downcount = downcount;
	}
	public int getCommentcount() {
		return commentcount;
	}
	public void setCommentcount(int commentcount) {
		this.commentcount = commentcount;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	String rsId;
	Modules modules;
	String title;
	String link;
	String thumbnail;
	String thumbnailV2;
	String duration;
	String published;
	String uptime;
	String player;
	String streamtypes;
	String flag;
	int viewCount;
	int favoriteCount;
	int upcount;
	int downcount;
	int commentcount;
	String tag;
	/*      
	 *   {
            "rsId": "XMzA0Mjg3MTgw",
            "modules": {
                "modulesId": 2,
                "modulesName": "旅游/指南",
                "sort": 7,
                "flag": "1",
                "icon": "http://beautyidea.oss-cn-hangzhou.aliyuncs.com/category_cover/journey.jpg"
            },
            "title": "法航广告：L'Envol",
            "link": "http://v.youku.com/v_show/id_XMzA0Mjg3MTgw.html",
            "thumbnail": "http://beautyidea.oss-cn-hangzhou.aliyuncs.com/video_thumb/XMzA0Mjg3MTgw.jpg",
            "thumbnailV2": "http://beautyidea.oss-cn-hangzhou.aliyuncs.com/video_thumb/XMzA0Mjg3MTgw.jpg",
            "duration": "60.00",
            "published": "2011-07-06 18:22:55",
            "uptime": "2014-11-27 17:10:00",
            "player": "http://k.youku.com/player/getFlvPath/sid/4416133587899123c59e8_01/st/flv/fileid/03000201004CA7FAE1D81B008F8F746863E0D7-F8F2-0A04-BE22-FCB3692B7AB0?K=cfe81188a95a968b261e0300&hd=0&myp=0&ts=62&ypp=2&ctype=12&ev=1&token=9556&oip=3079203019&ep=diaVHEiOVcsI4ivWgT8bZH%2FnfSIHXP4J9h%2BFg9JjALsgO5m470%2Bkxum4T41CFvFvelQBFO35rdOSajQTYYZL32oQ3z%2BoPfqSi%2FLh5dsgtpMGbxtEdbyltFSXRjX3",
            "streamtypes": "[\"hd2\",\"flvhd\",\"flv\",\"hd\",\"3gp\",\"3gphd\"]",
            "flag": "1",
            "viewCount": 3164,
            "favoriteCount": 0,
            "upcount": 0,
            "downcount": 0,
            "commentcount": 13,
            "tag": "法国，飞机，航空，唯美，旅行"
        },
	 * */
}
