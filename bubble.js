let xoff = 0.0;
let yoff = 0.0;
let coloroff = 0.0;
let incrementx = 0.011;
let incrementy = 0.010;


function setup() {
  createCanvas(710, 710);
  background(0);
  noStroke();
}

function draw() {
  // Create an alpha blended background
  fill(255, 2);
  rect(0, 0, width, height);


  // Get a noise value based on xoff and scale
  // it according to the window's width
  let n = noise(xoff) * width;
  let m = noise(yoff) * height;
  

  // With each cycle, increment xoff
  xoff += incrementx;
  yoff += incrementy;
  
  // temp = incrementx
  // incrementx = incrementy
  // incrementy = temp

  // Draw the ellipse at the value produced by perlin noise
  fill(0,100,(noise(xoff))*255);
  ellipse(n, m, 64, 64);
}
