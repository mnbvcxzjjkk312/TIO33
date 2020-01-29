package tischats;

import java.net.*;
import java.io.*;
import java.util.*;

/*
 * 특정 포트로 클라이어트 연결을 무한정 기다린다.
 * 클라이어트와 연결이 이루어지면 클라이어트와 통신을 담당할 스레드(TisChatHandler)를 생성한 후,
 * 스레드를 동작시킨다.
 * 여러명의 클라이언트와 통신하기 위해 TisChatHandler를 Vector에 저장하여 관리한다.
 */

public class TisChatServer extends Thread
{
	private ServerSocket server;
	private final int port = 7777;
	Vector<TisChatHandler> userV = new Vector<>();
	
	public TisChatServer()
	{
		try
		{
			server = new ServerSocket(port);
			System.out.println("채팅 서버가 시작됐어요.");
			System.out.println("[" + port + "]번 포트에서 대기중.");
		} 
		catch (IOException e)
		{
			System.out.println("##챗 서버 실행 중 예외 발생 : " + e + "##");
			return;
		}
	}// Constructor--------------------------------------------------------------
	
	
	
	
	
	
	
	
	@Override
	public void run()
	{
		while(true)
		{
			try	// try catch로 while문까지 감싸주게 되면 오류시 채팅이 종료되어 버린다. 
			{	// 오류가 나더라도 채팅을 지속시키기 위해서 socket만 안쪽으로 넣어준다.
				Socket sock = server.accept();
				String cip = sock.getInetAddress().getHostAddress();
				System.out.println("[" + cip + "]님이 접속했어요.");
				// 클라이언트와 통신을 담당할 TisChatHandler 스레드를 생성하고 동작시키자.
				// 이 때 sock과 userV를 인자로 넘긴다.
				TisChatHandler chat = new TisChatHandler(sock, userV);
				chat.start();	// 스레드 동작.
			} 
			catch (IOException e)
			{
				System.out.println("클라이언트의 소켓 생성 실패 : " + e);
			}
		}// while---------------------------------
	}// run()--------------------------------------------------------------------

	public static void main(String[] args)
	{
		TisChatServer tis = new TisChatServer();
		tis.start();
	}
}
