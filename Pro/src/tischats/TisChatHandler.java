package tischats;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Vector;

/*
 * 실질적으로 클라이언트와 메시지를 주고 받는 일을 한다.
 */

public class TisChatHandler extends Thread
{
	private Socket sock;
	private Vector<TisChatHandler> userV;
	private String uid, uChatName, uGender;		// 접속한 클라이언트의 정보를 저장할 변수.
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private boolean isStop = false;
	
	public TisChatHandler(Socket sock, Vector<TisChatHandler> userV)
	{
		this.sock = sock;
		this.userV = userV;
		
		try
		{
			in = new ObjectInputStream(this.sock.getInputStream());
			out = new ObjectOutputStream(this.sock.getOutputStream());
			/*
			 * [주의] 서버단에서 ObjectInputStream을 먼저 생성하면
			 * 		클라이언트단에서는 ObjectOutputStream을 먼저 생성해야 함.
			 */
		} 
		catch (IOException e)
		{
			System.out.println("TisChatHandler()에서 예외 발생 : " + e);
		}
		
		
	}///////////////////////////////////////////////////////////////////////
	
	@Override
	public void run()
	{
		// 1. 클라이언트가 접속하면 먼저 "대화명"을 보낸다.
		try
		{
			Object obj = in.readObject();
			if(obj instanceof String)
			{
				String str = (String)obj;
				String arr [] = str.split("\\|");
				this.uid = arr[0];
				this.uChatName = arr[1];
				this.uGender = arr[2];
			}
			
			boolean isExit = isDuplicated(uChatName);
			// 2. 대화명이 중복되었는지 여부를 체크.
			//	(1) 대화명이 중복된다면 "700|"을 클라이언트에게 보낸다.
			if(isExit)
			{
				sendMessageTo("700");
				isStop = true;
			}
			//	(2) 대화명이 중복되지 않는다면
			else
			{
				//		(2-1) 모든 참여자들에게 입장한 사람의 대화명을 보내준다.
				for(TisChatHandler userChat : userV)
				{
					String msg = "100|" + userChat.uid + "|" + userChat.uChatName + "|" + userChat.uGender;
					sendMessageTo(msg);
				}
				userV.add(this);
				
				//		(2-2) 방금 접속한 클라이언트에게 기존에 입장한 클라이언트들의 정보를 보내준다.
				String sendMsg = "100|" + this.uid + "|" + this.uChatName + "|" + this.uGender;
				sendMessageAll(sendMsg);
			}
			// 클라이언트가 보내오는 메시지를 계속 듣는다.
			while(!isStop)
			{
				String cmsg = (String)in.readObject();
				System.out.println(cmsg);
				// cmsg를 분석한다.
				parsing(cmsg);
			}// while----------------------------------------------------------------------------------
		} 
		catch (ClassNotFoundException | IOException e)
		{
			System.out.println("TisChatHandler run()에서 예외 발생 : " + e);
		}
	}

	private void parsing(String cmsg)
	{
		// "|" 를 기준으로 쪼개자.
		String [] tks = cmsg.split("\\|");
		switch(tks[0])
		{
			case "400" : 
			{
				// 클라이언트가  서버에게 보냄. "400|글꼴색|메시지"
				String fntRgb = tks[1];
				String message = tks[2];
				// 서버가 클라이언트에게 보냄. "400|대화명|글꼴색|메시지"
				String str = "400|" + this.uChatName + "|" + fntRgb + "|" + message;
				sendMessageAll(str);
				break;
			}
			case "500" :
			{
				// 클라이언트가 서버에게 보냄. "500|받을사람대화명|귓속말메시지"
				String to = tks[1];
				String message = tks[2];
				for(TisChatHandler userChat:userV)
				{
					if(to.equals(userChat.uChatName))
					{
						try
						{
							// 서버가 클라이언트에게 보낼 때, "500|보내는사람대화명|귓속말메시지"
							String str = "500|" + this.uChatName + "|" + message;
							userChat.sendMessageTo(str);
						} 
						catch (IOException e)
						{
							userV.remove(userChat);
							break;
						}
						break;
					}
				}
				break;
			}
			case "800" : 
			{
				// 클라이언트가 서버에게 보냄. "800|퇴장하는사람대화명"
				String logoutChatName = tks[1];
				sendMessageAll("800|" + logoutChatName);
				// 서버가 클라이언트에게 보냄. "800|퇴장하는사람대화명"
				userV.remove(this);
				closeAll();		// 모든 것을 닫아주는 메서드.
				break;
			}
			case "900" : 
			{
				// 클라이언트가 서버에게 뵤냄. "900|종료하는사람대화명"
				String logoutChatName = tks[1];
				sendMessageAll("900|" + logoutChatName);
				// 서버가 모든 클라이언트에게 "900|종료하는사람대화명"
				userV.remove(this);
				closeAll();
			}
			break;
		}// switch------------------------------------------------------------------
	}

	private void closeAll()
	{
		try
		{
			if(in != null) in.close();
			if(out != null) out.close();
			if(sock != null)
			{
				sock.close();
				sock = null;
			}
		} 
		catch (Exception e)
		{
			System.out.println("closeAll()에서 예외 발생 : " + e);
		}
	}

	// 대화명 중복 여부를 체크하는 메서드.
	private boolean isDuplicated(String chatName)
	{
		Enumeration<TisChatHandler> en = userV.elements();
		while(en.hasMoreElements())
		{
			TisChatHandler tisChat = en.nextElement();
			if(tisChat.uChatName.equals(chatName))
			{
				return true;	// 대화명 중복일 경우 true를 반환.
			}
		}// while--------------------------------------------------
		return false;
	}// isDuplicate()------------------------------------------------------------
	
	/** 서버와 접속한 특정 클라이언트 1명에게 메시지를 보냄.*/
	/* @throws IOException */
	private synchronized void sendMessageTo(String msg) throws IOException
	{
		out.writeObject(msg);
		out.flush();
	}// sendMessageTo()---------------------------------------------------------
	
	/** 서버와 접속한 모든 클라이언트에게 메시지를 보냄. */
	private synchronized void sendMessageAll(String sendMsg)
	{
		for(TisChatHandler userChat : userV)
		{
			try
			{
				userChat.sendMessageTo(sendMsg);
			} 
			catch (Exception e)
			{
				System.out.println("sendMessageAll()에서 예외 발생 : " + e);
				// 연결이 끊긴 클라이언트를 userV에서 제거.
				userV.remove(userChat);
			}
		}
	}// sendMessageAll()-------------------------------------------------------
}



























