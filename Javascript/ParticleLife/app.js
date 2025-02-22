function Update() {
	// if (window.innerWidth != canvas.clientWidth || window.innerHeight != canvas.clientHeight)
	// 	resizeCanvas()

	force(GLOBALS.PARTICLES.red, GLOBALS.PARTICLES.red, .5, 50)
	force(GLOBALS.PARTICLES.yellow, GLOBALS.PARTICLES.red, -.45, 100)

	context.clearRect(0, 0, canvas.clientWidth, canvas.clientHeight)
	draw(0, 0, canvas.clientWidth, canvas.clientHeight, "black")

	for (let i = 0; i < particles.length; i++) {
		particles[i].accelerator.speedUp(0.1)
		particles[i].accelerator.move(0.5)
		particles[i].adjustPositionBoard()
		draw(
			particles[i].transform.position.x - (particles[i].width / 2),
			particles[i].transform.position.y - (particles[i].height / 2),
			particles[i].width,
			particles[i].height,
			particles[i].color
		)
	}

	requestAnimationFrame(Update)
}

function force(group1, group2, g = G, maxDistance = 80) {
	for (let i = 0; i < group1.length; i++) {
		const particle1 = group1[i]

		particle1.accelerator.resetSpeed()

		for (let j = 0; j < group2.length; j++) {
			const particle2 = group2[j]

			if (particle1.id == particle2.id)
				continue

			const distance = Vector2.distance(particle1.transform.position, particle2.transform.position)

			if (distance <= 0 || distance >= maxDistance)
				continue

			const forceAcceleration = calculateAcceleration(
				particle1.transform.position,
				particle2.transform.position,
				g
			)

			particle1.accelerator.speedUpToX(forceAcceleration.x)
			particle1.accelerator.speedUpToY(forceAcceleration.y)
		}
	}
}

window.onload = () => {
	Update()
}