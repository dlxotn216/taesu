package net.madvirus.spring4.eqgroup.vo;

public class EqGroupForSelect {
	private Long 	group_id;
	private String 	comp_code;
	private String 	group_nm;
	private Long 	upper_group_id;
	private String 	lat;
	private String 	lng;
	private Integer group_depth;
	private String 	group_prefix;
	
	public Long getGroup_id() {
		return group_id;
	}
	public void setGroup_id(Long group_id) {
		this.group_id = group_id;
	}
	public String getComp_code() {
		return comp_code;
	}
	public void setComp_code(String comp_code) {
		this.comp_code = comp_code;
	}
	public String getGroup_nm() {
		return group_nm;
	}
	public void setGroup_nm(String group_nm) {
		this.group_nm = group_nm;
	}
	public Long getUpper_group_id() {
		return upper_group_id;
	}
	public void setUpper_group_id(Long upper_group_id) {
		this.upper_group_id = upper_group_id;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public Integer getGroup_depth() {
		return group_depth;
	}
	public void setGroup_depth(Integer group_depth) {
		this.group_depth = group_depth;
	}
	public String getGroup_prefix() {
		return group_prefix;
	}
	public void setGroup_prefix(String group_prefix) {
		this.group_prefix = group_prefix;
	}
	
	
}
