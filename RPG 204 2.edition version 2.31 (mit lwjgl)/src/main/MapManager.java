package main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.util.Log;

public class MapManager {

//	Map map;
	SpriteSheet sprite;
	private int[][] map = null;
	private int height;
	private int width;
	private JSONObject obj = null;
	
	public MapManager(String name) {
//		map = new Map(name);
		init(name);
	}
	
	private void init(String name) {
		try {
			map = getMap("src\\maps\\" + name); // Das sollte so funktionieren
			
			sprite = new SpriteSheet("img/spritesheet.png", 16, 16); // Das sollte so auch funktionieren, da ich hier nichts geändert habe
		} catch (SlickException e) {
			Log.error(e);
		} catch (IOException e) {
			Log.error(e);
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
	
	
	private int[][] getMap (String path) throws IOException {
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
			
			
			System.out.println("");

		} catch (JSONException e) {
			Log.error(e);
		}
		return map;
	}

	
	
	/////////////////////////////////
	////    getter/setter        ////
	/////////////////////////////////
	
	
	public Polygon getHitbox(int position) {
		Polygon p = null;
		
		try {
			JSONArray tilesetsArray = obj.getJSONArray("tilesets");
			JSONObject tilesetObject = tilesetsArray.getJSONObject(0);
			
			JSONObject tilesObject = tilesetObject.getJSONObject("tiles");
			
			JSONObject finalTile = null;
			if (tilesObject.has(String.valueOf(position))) {
				finalTile = tilesObject.getJSONObject(String.valueOf(position)); // hier gebe ich an, welches Tile ich haben will
			} else {
				return null;
			}
			
			JSONObject objectgroupObject = finalTile.getJSONObject("objectgroup");
			
			JSONArray objectsArray = objectgroupObject.getJSONArray("objects");
			JSONObject objectsObject = objectsArray.getJSONObject(0);
			
			JSONArray polylineArray = objectsObject.getJSONArray("polyline");
			
			float[] points = new float[polylineArray.length()*2];
			
			
			for (int i = 0; i < polylineArray.length()*2; i+=2) {
				JSONObject polylineObject = polylineArray.getJSONObject(i/2);
				points[i] = (float) polylineObject.getDouble("x")+Offset.getX()/4;
				points[i+1] = (float) polylineObject.getDouble("y")+Offset.getY()/4;
			}
			
			p = new Polygon(points);
			
			
			
			
		} catch (JSONException ex) {
			Log.error(ex);
		}
		return p;
		
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


	
	
	
	
	

//	@Deprecated
//	public Block[][] init() throws SlickException {
//		sheet = new SpriteSheet("img/spritesheet.png", 16, 16);
//		
//		Block[][] block = new Block[100][100];
//		
//		
//		Image steinImg = sheet.getSubImage(1, 1);
//		Image steinObenImg = sheet.getSubImage(1, 0);
//		Image steinUntenImg = sheet.getSubImage(1, 2);
//		Image steinRechteImg = sheet.getSubImage(2, 1);
//		Image steinLinksImg = sheet.getSubImage(0, 1);
//		Image steinORImg = sheet.getSubImage(2, 0);
//		Image steinOLImg = sheet.getSubImage(0, 0);
//		Image steinURImg = sheet.getSubImage(2, 2);
//		Image steinULImg = sheet.getSubImage(0, 2);
//		
//		Image steinUREImg = sheet.getSubImage(3, 0);
//		Image steinULEImg = sheet.getSubImage(4, 0);
//		Image steinOREImg = sheet.getSubImage(3, 1);
//		Image steinOLEImg = sheet.getSubImage(4, 1);
//		
//		
//		Image steinLOZImg = sheet.getSubImage(5, 0);
//		Image steinLUZImg = sheet.getSubImage(5, 1);
//		Image steinROZImg = sheet.getSubImage(6, 0);
//		Image steinRUZImg = sheet.getSubImage(6, 1);
//		Image steinORZImg = sheet.getSubImage(8, 0);
//		Image steinOLZImg = sheet.getSubImage(7, 0);
//		Image steinURZImg = sheet.getSubImage(8, 1);
//		Image steinULZImg = sheet.getSubImage(7, 1);
//		Image steinORAImg = sheet.getSubImage(3, 3);
//		Image steinULAImg = sheet.getSubImage(4, 2);
//		Image steinURAImg = sheet.getSubImage(3, 2);
//		Image steinOLAImg = sheet.getSubImage(4, 3);
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		Image tuerZu = sheet.getSubImage(0, 9);
//		
//		
//		
//		
//		
//		
//		Image grundgesteinImg = sheet.getSubImage(0, 3);
//		
//		
//		Image moosImg = sheet.getSubImage(10, 1);
//
//		
//		Image luftImg = sheet.getSubImage(10, 0);
//		
//
//		
//		//jede map m�sste 100*100 groﾟ sein. Sp舩er das in ner extra Datei (oder so) gespeichert wird wie groﾟ die ist und andere Infos. Oder die gre vllt anders herausfinden
//		
//		float[] points;
//		
//		for (int i = 0; i < 100; i++) {
//			for (int j = 0; j < 100; j++) {
//				switch(map.getTile(i, j)) {
//				case Stein:
//					block[i][j] = new Block(Block.blockType.Stein, steinImg, null);
//					break;
//					
//				case SteinOben:
//					block[i][j] = new Block(Block.blockType.SteinOben, steinObenImg, new Rectangle(0+i*32, 0+j*32, 32, 8));
//					break;
//					
//				case SteinUnten:
//					block[i][j] = new Block(Block.blockType.SteinUnten, steinUntenImg, new Rectangle(0+i*32, 24+j*32, 32, 8));
//					break;
//					
//				case SteinRechts:
//					block[i][j] = new Block(Block.blockType.SteinRechts, steinRechteImg, new Rectangle(24+i*32, 0+j*32, 8, 32));
//					break;
//					
//				case SteinLinks:
//					block[i][j] = new Block(Block.blockType.SteinLinks, steinLinksImg, new Rectangle(0+i*32, 0+j*32, 8, 32));
//					break;
//					
//				case SteinOR:
//					points = new float[] {0+i*32, 0+j*32, 32+i*32, 0+j*32, 32+i*32, 32+j*32, 24+i*32, 32+j*32, 24+i*32, 8+j*32, 0+i*32, 8+j*32};
//					
////					block[i][j] = new Block(Block.blockType.SteinOR, steinORImg, new Rectangle(24+i*32, 0+j*32, 8, 8));
//					block[i][j] = new Block(Block.blockType.SteinOR, steinORImg, new Polygon(points));
//					break;
//					
//				case SteinOL:
//					points = new float[] {0+i*32, 0+j*32, 32+i*32, 0+j*32, 32+i*32, 8+j*32, 8+i*32, 8+j*32, 8+i*32, 32+j*32, 0+i*32, 32+j*32};
//					
//					block[i][j] = new Block(Block.blockType.SteinOL, steinOLImg, new Polygon(points));
////					block[i][j] = new Block(Block.blockType.SteinOL, steinOLImg, new Rectangle(0+i*32, 0+j*32, 8, 8));
//					break;
//					
//				case SteinUR:
//					points = new float[] {24+i*32, 0+j*32, 32+i*32, 0+j*32, 32+i*32, 32+j*32, 0+i*32, 32+j*32, 0+i*32, 24+j*32, 24+i*32, 24+j*32};
//					
////					block[i][j] = new Block(Block.blockType.SteinUR, steinURImg, new Rectangle(24+i*32, 24+j*32, 8, 8));
//					block[i][j] = new Block(Block.blockType.SteinUR, steinURImg, new Polygon(points));
//					break;
//					
//				case SteinUL:
//					points = new float[] {0+i*32, 0+j*32, 8+i*32, 0+j*32, 8+i*32, 24+j*32, 32+i*32, 24+j*32, 32+i*32, 32+j*32, 0+i*32, 32+j*32};
//					
////					block[i][j] = new Block(Block.blockType.SteinUL, steinULImg, new Rectangle(0+i*32, 24+j*32, 8, 8));
//					block[i][j] = new Block(Block.blockType.SteinUL, steinULImg, new Polygon(points));
//					break;
//					
//				case SteinORE:
//					block[i][j] = new Block(Block.blockType.SteinORE, steinOREImg, new Rectangle(24+i*32, 0+j*32, 8, 8));
//					break;
//					
//				case SteinOLE:
//					block[i][j] = new Block(Block.blockType.SteinOLE, steinOLEImg, new Rectangle(0+i*32, 0+j*32, 8, 8));
//					break;
//					
//				case SteinURE:
//					block[i][j] = new Block(Block.blockType.SteinURE, steinUREImg, new Rectangle(24+i*32, 24+j*32, 8, 8));
//					break;
//					
//				case SteinULE:
//					block[i][j] = new Block(Block.blockType.SteinULE, steinULEImg, new Rectangle(0+i*32, 24+j*32, 8, 8));
//					break;
//					
//					
//				case SteinLOZ:
//					block[i][j] = new Block(Block.blockType.SteinLOZ, steinLOZImg, new Rectangle(0+i*32, 0+j*32, 8, 32));
//					break;
//					
//				case SteinLUZ:
//					block[i][j] = new Block(Block.blockType.SteinLUZ, steinLUZImg, new Rectangle(0+i*32, 0+j*32, 8, 32));
//					break;
//					
//				case SteinROZ:
//					block[i][j] = new Block(Block.blockType.SteinROZ, steinROZImg, new Rectangle(24+i*32, 0+j*32, 8, 32));
//					break;
//					
//				case SteinRUZ:
//					block[i][j] = new Block(Block.blockType.SteinRUZ, steinRUZImg, new Rectangle(24+i*32, 0+j*32, 8, 32));
//					break;
//					
//				case SteinORZ:
//					block[i][j] = new Block(Block.blockType.SteinORZ, steinORZImg, new Rectangle(0+i*32, 0+j*32, 32, 8));
//					break;
//					
//				case SteinOLZ:
//					block[i][j] = new Block(Block.blockType.SteinOLZ, steinOLZImg, new Rectangle(0+i*32, 0+j*32, 32, 8));
//					break;
//					
//				case SteinURZ:
//					block[i][j] = new Block(Block.blockType.SteinURZ, steinURZImg, new Rectangle(0+i*32, 24+j*32, 32, 8));
//					break;
//					
//				case SteinULZ:
//					block[i][j] = new Block(Block.blockType.SteinULZ, steinULZImg, new Rectangle(0+i*32, 24+j*32, 32, 8));
//					break;
//					
//				case SteinORA:
//					points = new float[] {0+i*32, 0+j*32, 32+i*32, 0+j*32, 32+i*32, 32+j*32, 24+i*32, 32+j*32, 24+i*32, 8+j*32, 0+i*32, 8+j*32};
//					
//					block[i][j] = new Block(Block.blockType.SteinORA, steinORAImg, new Polygon(points));
//					break;
//					
//				case SteinOLA:
//					points = new float[] {0+i*32, 0+j*32, 32+i*32, 0+j*32, 32+i*32, 8+j*32, 8+i*32, 8+j*32, 8+i*32, 32+j*32, 0+i*32, 32+j*32};
//					
//					block[i][j] = new Block(Block.blockType.SteinOLA, steinOLAImg, new Polygon(points));
//					break;
//					
//				case SteinURA:
//					points = new float[] {24+i*32, 0+j*32, 32+i*32, 0+j*32, 32+i*32, 32+j*32, 0+i*32, 32+j*32, 0+i*32, 24+j*32, 24+i*32, 24+j*32};
//					
//					block[i][j] = new Block(Block.blockType.SteinURA, steinURAImg, new Polygon(points));
//					break;
//					
//				case SteinULA:
//					points = new float[] {0+i*32, 0+j*32, 8+i*32, 0+j*32, 8+i*32, 24+j*32, 32+i*32, 24+j*32, 32+i*32, 32+j*32, 0+i*32, 32+j*32};
//					
//					block[i][j] = new Block(Block.blockType.SteinULA, steinULAImg, new Polygon(points));
//					break;
//					
//					
//					
//					
//					
//					
//					
//					
//				case tuerZu:
//					block[i][j] = new Block(Block.blockType.tuerZu, tuerZu, new Rectangle(0+i*32, 0+j*32, 8, 32));
//					break;
//					
//					
//					
//				case Grundgestein:
//					block[i][j] = new Block(Block.blockType.Grundgestein, grundgesteinImg, null);
//					break;
//					
//				case Moos:
//					block[i][j] = new Block(Block.blockType.Moos, moosImg, null/*new Rectangle(0+i*16, 0+j*16, 16, 16)*/);
//					break;
//					
//				case Luft: //nichts machen. Oder doch. Oder auch nicht. Doch!!!! Sonst Fehler
//					block[i][j] = new Block(Block.blockType.Luft, luftImg, null);
//					break;
//					
//					
//				default:
//					System.out.println("Default im MapManager");
//					break;
//					
//				}
//				
//				
////				block[i][j] = map.getTile(i, j);				
//			}
//		}
//		return block;
//	}

	
	
	
}

