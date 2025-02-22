const canvas = document.querySelector("#canvas")
const context = canvas.getContext("2d")
// resizeCanvas()

function resizeCanvas() {
	canvas.width = window.innerWidth
	canvas.height = window.innerHeight
}

const GLOBALS = {
	SIZE_PARTICLE: { width: 10, height: 10 },
	PARTICLES: {
		yellow: [],
		red: [],
		green: [],
	}
}

const particles = []

GLOBALS.PARTICLES.yellow = generateParticles(1000, "yellow")
GLOBALS.PARTICLES.red = generateParticles(400, "red")
// GLOBALS.PARTICLES.green = generateParticles(200, "green")

function draw(x, y, w, h, color) {
	context.fillStyle = color
	context.fillRect(x, y, w, h)
}

function generateRandomPosition() {
	return new Vector2(
		Math.random() * canvas.clientWidth,
		Math.random() * canvas.clientHeight
	)
}

function generateParticles(amount, color) {
	const group = []

	for (let i = 0; i < amount; i++) {
		const randomPosition = generateRandomPosition()
		const particle = new Particle(randomPosition.x, randomPosition.y, GLOBALS.SIZE_PARTICLE.width, GLOBALS.SIZE_PARTICLE.height)
		particle.color = color

		particles.push(particle)
		group.push(particle)
	}

	return group
}

function calculateAcceleration(position1, position2, gravity = 1) {
	const diference = Vector2.diference(position1, position2)
	const distance = Vector2.distance(position1, position2)

	const F = -gravity * 1 / distance

	return new Vector2(F * diference.x, F * diference.y)
}

// FORCE GRAVITATIONAL
const converterScale = 9.534285714285713e-13
const G = (6.674 * (10 ** -11)) / converterScale

function calculateAccelerationGravitational(position1, position2, mass1, mass2, size2, gravity = 1) {
	const forceGravitational = calculateForceGravitational(position1, position2, mass1, mass2, size2, gravity)
	const angle = PositionHelper.calculateAngleInRadians(position1.x, position1.y, position2.x, position2.y)
	return PositionHelper.calculateDistancePosition(angle, forceGravitational)
}

function calculateForceGravitational(position1, position2, mass1, mass2, size2, gravity = 1) {
	return (calculateGForceBody(gravity, mass2, size2) * ((mass1 * mass2) / Vector2.distance(position1, position2)))
}

function calculateGForceBody(gravity, mass, size = 1) {
	return (-gravity * mass) / (size || 1) ** 2
}