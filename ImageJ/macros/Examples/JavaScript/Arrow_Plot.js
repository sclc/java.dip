// This script demonstrates how to plot a field of 
// arrows and combine it with other plot objects. 

  gridSize = 20;
  n = gridSize*gridSize;
  increment = 1.0/(gridSize-1);
  xS = new Array(n);
  yS = new Array(n);
  xE = new Array(n);
  yE = new Array(n);
  i = 0;
  for (y=0; y<=1.000001; y+=increment) {
    for (x=0; x<=1.000001; x+=increment) {
      xS[i] = x;
      yS[i] = y;
      dx = (0.45+0.45*Math.sin(2*Math.PI*y))/gridSize;
      dy = 0.9*Math.cos(2*Math.PI*x+0.75*Math.PI*y)/gridSize;
      xE[i] = x + dx;
      yE[i] = y + dy;
      i++;
    }
  }
  plot = new Plot("Arrow Field Plot","X Axis","Y Axis");
  plot.setColor("blue");
  plot.drawVectors(xS, yS, xE, yE);
  xLine = new Array(-1, 2);
  yLine = new Array(0.75, 0.75);
  plot.setColor("red");
  plot.add("line", xLine, yLine);
  plot.setColor("black"); //legend frame
  plot.addLegend("x component vanishes here", "top-left");
  plot.show();
