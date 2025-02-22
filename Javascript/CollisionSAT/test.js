function App() {
	let vertices = [{
		x: 1,
		y: 1
	}, {
		x: 1,
		y: -1
	}, {
		x: -1,
		y: -1
	}, {
		x: -1,
		y: 1
	}];

	// get the perpendicular axis - you would need to loop over these...
	let axis = {
		x: -(vertices[1].y - vertices[0].y),
		y: vertices[1].x - vertices[0].x
	}

	// be sure to normalize the axis by making it length to 1. You can do that with something like
	let magnitude = Math.sqrt(Math.pow(axis.x, 2), Math.pow(axis.y, 2));
	if (magnitude != 0) {
		axis.x *= 1 / magnitude;
		axis.y *= 1 / magnitude;
	}

	// helper method for calculating the dot product of a vector
	function vectorDotProduct(pt1, pt2) {
		return (pt1.x * pt2.x) + (pt1.y * pt2.y);
	}

	// verts and axis from earlier...
	//   vertices = [ {x:1, y:1}, {x:1, y:-1}, {x:-1, y:-1}, {x:-1, y:1} ];  
	//   axis = {x:1, y: 0}

	// get an initial min/max value.  you will need the min max for both shapes
	let p1min = vectorDotProduct(axis, vertices[0]);
	let p1max = p1min;

	// loop over all the other vertices to complete the range
	for (let i = 1; i < vertices.length; i++) {
		let dot = vertices[i];
		p1min = Math.min(p1min, dot);
		p1max = Math.max(p1max, dot);
	}

	debugger
}

App()