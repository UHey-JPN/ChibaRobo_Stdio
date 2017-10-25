package main;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import communication.udp.StateUpdateListener;
import communication.udp.UdpSocket;
import data.communication.StateData;
import window.logger.LogToSystemIO;

public class ChibaRobo_Stdio implements StateUpdateListener {

	public ChibaRobo_Stdio() {
		Executor ex = Executors.newCachedThreadPool();

		UdpSocket udp = new UdpSocket(ex, new LogToSystemIO());
		udp.add_StateUpdateListener(this);
	}

	public static void main(String[] args) {
		new ChibaRobo_Stdio();

	}

	
	@Override
	public void state_update(StateData state) {
		String ret = "show";
		ret += "," + state.get_mode();
		ret += "," + state.get_c_start_time().getTimeInMillis();
		ret += "," + state.get_score()[0] + "," + state.get_score()[1];
		System.out.println(ret);
		
	}

}
