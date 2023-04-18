package com.polus_plus.tmedic.POJO.UserProfile;

public class Avatar {
	byte[] binary;
	
	public Avatar(byte[] binary) {
		this.binary = binary;
	}
	
	public byte[] getBinary() {
		return binary;
	}
	public void setBinary(byte[] binary) {
		this.binary = binary;
	}
}