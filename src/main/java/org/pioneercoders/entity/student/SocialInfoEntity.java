package org.pioneercoders.entity.student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.pioneercoders.entity.user.UserEntity;
@Entity
@Table(name="user_social_info_tbl")
public class SocialInfoEntity {
	
	 private long id;
	 private String facebookId;
	 private String twitterId;
	 private String  skypeId;
	 private String whatsappNo;
	 private UserEntity user;
	 
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name="FACEBOOK_ID")
	public String getFacebookId() {
		return facebookId;
	}
	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}
	
	@Column(name="TWITTER_ID")
	public String getTwitterId() {
		return twitterId;
	}
	public void setTwitterId(String twitterId) {
		this.twitterId = twitterId;
	}
	
	
	@Column(name="SKYPE_ID")
	public String getSkypeId() {
		return skypeId;
	}
	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
	}
	
	@Column(name="WHATSAPP_NO")
	public String getWhatsappNo() {
		return whatsappNo;
	}
	public void setWhatsappNo(String whatsappNo) {
		this.whatsappNo = whatsappNo;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID")
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "SocialInfoEntity [id=" + id + ", facebookId=" + facebookId
				+ ", twitterId=" + twitterId + ", skypeId=" + skypeId
				+ ", whatsappNo=" + whatsappNo + ", user=" + user + "]";
	}	

	
	 

}
