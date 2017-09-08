package main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.util.Log;

public class MapManager {

	SpriteSheet sprite;
	private int[][] map = null;
	private Map<Integer, Polygon> hitbox = null;
	private int height;
	private int width;
	private JSONObject obj = null;
	
	public MapManager(String name) {
		initMap(name);
		initSprite();
		
		
		
	}
	
	private void initMap(String name) {
		try {
			map = loadMap("src\\maps\\" + name);
			hitbox = loadHitbox();
		} catch (IOException e) {
			Log.error(e);
		}
	}
	
	private void initSprite() {
		try {
			sprite = new SpriteSheet("img/spritesheet.png", 16, 16);
		} catch (SlickException e) {
			e.printStackTrace();
		}	
	}
	
	
	private void readJsonMap(String path) throws IOException {
		BufferedReader br = null;
		InputStream is = null;
		InputStreamReader isr = null;
		
		try {
			is = new FileInputStream(path);
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);

			String line = null;
			StringBuilder jsonData = new StringBuilder();

			line = br.readLine();
			while (line != null) {
				jsonData.append(line + "\n");
				line = br.readLine();
			}

			obj = new JSONObject(jsonData.toString());
		} catch (FileNotFoundException ex) {
			Log.error(ex);
		} catch (IOException ex) {
			Log.error(ex);
		} catch (JSONException ex) {
			Log.error(ex);
		} finally {
			br.close();
			is.close();
			isr.close();
		}
	}
	
	/**
	 * Einlesen der JSON-Datei und speicherung der "Map" in einem 2-Dimenstionalem int-Array
	 * 
	 * @param path
	 * @return
	 * @throws IOException
	 */
	private int[][] loadMap (String path) throws IOException {
		readJsonMap(path);
		
		int[][] map = null;
		
		
		try {
			JSONArray layerArray = obj.getJSONArray("layers");
			JSONObject layerObject = layerArray.getJSONObject(0);
			
			height = layerObject.getInt("height");
			width = layerObject.getInt("width");
			
			JSONArray dataArray = layerObject.getJSONArray("data");
			
			map = new int [height][width];
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					map[i][j] = dataArray.getInt(i+j*100);
				}
			}
			

		} catch (JSONException e) {
			Log.error(e);
		}
		return map;
	}

	/**
	 * speichern der Hitbox-Daten in einem 2-Dimensionalem Polygon-Array
	 * 
	 * @return
	 */
	private Map<Integer, Polygon> loadHitbox() {
//		Polygon[][] polMap = new Polygon[100][100];
		Map<Integer, Polygon> polMap = new HashMap<Integer, Polygon>();
		
		try {
			for (int i = 0; i < 10000; i++) {
//					int position = i+j*16;
				int position = i;	
				
					JSONArray tilesetsArray = obj.getJSONArray("tilesets");
					JSONObject tilesetObject = tilesetsArray.getJSONObject(0);
					
					JSONObject tilesObject = tilesetObject.getJSONObject("tiles");
					
					JSONObject finalTile = null;
					if (tilesObject.has(String.valueOf(position))) {
						finalTile = tilesObject.getJSONObject(String.valueOf(position)); // hier gebe ich an, welches Tile ich haben will
					} else {
						continue;
					}
					
					JSONObject objectgroupObject = finalTile.getJSONObject("objectgroup");
					
					JSONArray objectsArray = objectgroupObject.getJSONArray("objects");
					JSONObject objectsObject = objectsArray.getJSONObject(0);
					
					JSONArray polylineArray = objectsObject.getJSONArray("polyline");
					
					float[] points = new float[polylineArray.length()*2];
					
					
					for (int k = 0; k < polylineArray.length()*2; k+=2) {
						JSONObject polylineObject = polylineArray.getJSONObject(k/2);
						points[k] = (float) polylineObject.getDouble("x")+Offset.getX()/4;
						points[k+1] = (float) polylineObject.getDouble("y")+Offset.getY()/4;
					}
					
//					polMap[i][j] = new Polygon(points);
					polMap.put(i, new Polygon(points));
					
				}
			
		} catch (JSONException ex) {
			Log.error(ex);
		}
		return polMap;
		
	}
	
	
	/////////////////////////////////
	////    getter/setter        ////
	/////////////////////////////////
	
	public Polygon getHitbox(int position) {
		position--;
		if (position < 0) {
			return null;
		}
		Polygon p = hitbox.get(position);
		if (p == null) {
			return null;
		}
		
		float[] pn = new float[p.getPointCount()*2];
//		List<Float> pn = new ArrayList<Float>();
		
		for (int i = 0; i < p.getPointCount(); i++) {
			float[] p1 = p.getPoint(i);
			
				pn[i*2] = p1[0] + Offset.getX()/4;
				pn[i*2+1] = p1[1] + Offset.getY()/4;
			
		}
		
		
		return new Polygon(pn); 
		
//		Polygon p = null;
//		
//		try {
//			JSONArray tilesetsArray = obj.getJSONArray("tilesets");
//			JSONObject tilesetObject = tilesetsArray.getJSONObject(0);
//			
//			JSONObject tilesObject = tilesetObject.getJSONObject("tiles");
//			
//			JSONObject finalTile = null;
//			if (tilesObject.has(String.valueOf(position))) {
//				finalTile = tilesObject.getJSONObject(String.valueOf(position)); // hier gebe ich an, welches Tile ich haben will
//			} else {
//				return null;
//			}
//			
//			JSONObject objectgroupObject = finalTile.getJSONObject("objectgroup");
//			
//			JSONArray objectsArray = objectgroupObject.getJSONArray("objects");
//			JSONObject objectsObject = objectsArray.getJSONObject(0);
//			
//			JSONArray polylineArray = objectsObject.getJSONArray("polyline");
//			
//			float[] points = new float[polylineArray.length()*2];
//			
//			
//			for (int i = 0; i < polylineArray.length()*2; i+=2) {
//				JSONObject polylineObject = polylineArray.getJSONObject(i/2);
//				points[i] = (float) polylineObject.getDouble("x")+Offset.getX()/4;
//				points[i+1] = (float) polylineObject.getDouble("y")+Offset.getY()/4;
//			}
//			
//			p = new Polygon(points);
//			
//			
//			
//			
//		} catch (JSONException ex) {
//			Log.error(ex);
//		}
//		return p;
	}

	
	public Image getImage(int position) {
		if (position == 0) {
			return sprite.getSubImage(15*16, 15*16, 16, 16);
		} else {
			position--;
			int x = position % 16;
			int y = position / 16;
			return sprite.getSubImage(x*16, y*16, 16, 16);
		}
	}

	
	
	public int getTile(int x, int y) {
		return map[x][y];
	}
	
	
	public int getHeight() {
		return height;
	}
	
	
	public int getWidth() {
		return width;
	}
	
	


//	public static void main(String[] args) {
//		MapManager m = new MapManager("map1.json");
//		m.getHitbox(1);
//	}

	
	
}

