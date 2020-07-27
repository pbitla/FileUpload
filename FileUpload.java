package com.example.demo;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class FileUpload {
	
	// Option1:
	public static void main(String[] args) {
		String remoteDir = "/upload";
		String localPath = "/Users/bitla/STS_workspace/demo-1/src/main/resources/input.txt";

		JSch jsch;
		Session session;
		Channel channel;
		ChannelSftp channelSftp;

		try {
			jsch = new JSch();

			session = jsch.getSession("praveen", "127.0.0.1", 22);
			session.setPassword("testing");
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			
			// if you have proxy
			//ProxyHTTP  proxy = new ProxyHTTP("HOST_NAME",PORT_NUMBER)
			//proxy.setUserPasswd("username","password");
			//session.setProxy(proxy);
			
			session.setConfig(config);
			session.connect();
			channel = session.openChannel("sftp");
			channel.connect();
			channelSftp = (ChannelSftp) channel;
			channelSftp.cd(remoteDir);

			channelSftp.put(localPath, remoteDir);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
