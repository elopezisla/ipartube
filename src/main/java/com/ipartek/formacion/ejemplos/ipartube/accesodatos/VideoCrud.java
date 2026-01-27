package com.ipartek.formacion.ejemplos.ipartube.accesodatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

//import com.ipartek.formacion.ejemplos.ipartube.modelos.Usuario;
import com.ipartek.formacion.ejemplos.ipartube.modelos.Video;

public class VideoCrud {
private static final ArrayList<Video> VIDEOS = new ArrayList<Video>();
	
	static {
		for(long i = 1; i <= 9; i++) {
			Video video = new Video(i, "Video " + i, "Descripción del video " + i, "https://picsum.photos/1600/900?" + i, 
					LocalDateTime.now(), "https://www.youtube.com/embed/xb50ooBETEc?si=38vrolrMa8AQCEhN");
			VIDEOS.add(video);
		}
	}
	
	public static ArrayList<Video> obtenerTodos() {
		return VIDEOS;
	}

	public static Video obtenerPorId(Long id) {
		return VIDEOS.stream().filter(v -> v.id() == id).findFirst().get();
	}
	
}
