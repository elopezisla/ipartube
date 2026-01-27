package com.ipartek.formacion.ejemplos.ipartube.accesodatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

//import com.ipartek.formacion.ejemplos.ipartube.modelos.Usuario;
import com.ipartek.formacion.ejemplos.ipartube.modelos.Video;

public class VideoCrud {
	public static ArrayList<Video> obtenerTodos() {
		try(PreparedStatement pst = JdbcHelper.prepararSql("select * from videos");
				ResultSet rs = pst.executeQuery()) {
			ArrayList<Video> videos = new ArrayList<>();
			
			while(rs.next()) {
				long id = rs.getLong("id");
				String titulo = rs.getString("titulo");
				String descripcion = rs.getString("descripcion");
				String imagenUrl = rs.getString("imagen_url");
				Timestamp timestamp = rs.getTimestamp("fecha");
				LocalDateTime fecha = timestamp != null ? timestamp.toLocalDateTime() : null;
				String videoUrl = rs.getString("video_url");
				
				Video video = new Video(id, titulo, descripcion, imagenUrl, fecha, videoUrl);
				
				videos.add(video);
			}
			return videos;
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}


	public static Video obtenerPorId(Long id) {
        Video video = null; 

        try (PreparedStatement pst = JdbcHelper.prepararSql("select * from videos where id=?")) {

            pst.setLong(1, id);

            try (ResultSet rs = pst.executeQuery()) {

                if (rs.next()) {
                    String titulo = rs.getString("titulo");
                    String descripcion = rs.getString("descripcion");
                    String imagenUrl = rs.getString("imagen_url");

                    Timestamp timestamp = rs.getTimestamp("fecha");
                    LocalDateTime fecha = timestamp != null ? timestamp.toLocalDateTime() : null;

                    String videoUrl = rs.getString("video_url");

                    video = new Video(id, titulo, descripcion, imagenUrl, fecha, videoUrl);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return video; 
    }
	
}
