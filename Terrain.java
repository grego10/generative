int cols, rows;
int scl = 20;
int w = 4000;
int h = 2000;

float flying = 0;

//terrain coordinate
float[][] terrain;

//triangle color
float[][] colorR;
float[][] colorG;
float[][] colorB;

void setup() {
  size(900, 800, P3D);
  cols = w/scl;
  rows = h/scl;
  terrain = new float[cols][rows];
  colorR = new float[cols][rows];
  colorG = new float[cols][rows];
  colorB = new float[cols][rows];
}


void draw() {
  flying -= 0.035;
  float yoff = flying;
  float ycol = flying;
  
  //randomizing color and height
  for (int y = 0; y < rows; y++) {
    float xoff = 0;
    float xcol = 0;
    for(int x = 0; x < cols; x++) {
      terrain[x][y] = map(noise(xoff, yoff), 0, 1, -100, 100);
      colorR[x][y] = map(noise(xcol, ycol), 0, 1, 175, 255);
      colorG[x][y] = map(noise(xcol, ycol), 0, 1, 25, 50);
      colorB[x][y] = map(noise(xcol, ycol), 0, 1, 0, 255);
      xcol += 0.25;
      xoff += 0.1;
    }
    ycol += 0.25;
    yoff += 0.1;
  }
   
  background(0, 83, 159);
  stroke(255);
  
  // draw relative to center of window
  translate(width/2,height/2);
  rotateX(PI/3);
  translate(-w/2,-h/5);
  
  for(int y = 0; y < rows-1; y++){
    beginShape(TRIANGLE_STRIP);
    for(int x = 0; x < cols; x++) {
      fill(colorR[x][y],colorG[x][y],colorB[x][y]);
      vertex(x*scl, y*scl, terrain[x][y]);
      vertex(x*scl, (y+1)*scl, terrain[x][y+1]);
    }
    endShape();
  }
}
