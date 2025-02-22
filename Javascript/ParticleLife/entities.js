class Particle {
	constructor(x, y, w, h, color) {
		this.id = Math.random().toString(16).slice(2)
		this.transform = new Transform(x, y)
		this.accelerator = new Accelerator(this.transform)
		this.width = w
		this.height = h
		this.color = color
	}

	adjustPositionBoard() {
		if (this.transform.position.x < 0) {
			this.transform.position.x = 0
			this.accelerator.setAccelerationX(-this.accelerator.acceleration.x)
			this.accelerator.setSpeedX(-this.accelerator.speed.x)
		} else if (this.transform.position.x + this.width > canvas.clientWidth) {
			this.transform.position.x = canvas.clientWidth - this.width
			this.accelerator.setAccelerationX(-this.accelerator.acceleration.x)
			this.accelerator.setSpeedX(-this.accelerator.speed.x)
		}
		if (this.transform.position.y < 0) {
			this.transform.position.y = 0
			this.accelerator.setAccelerationY(-this.accelerator.acceleration.y)
			this.accelerator.setSpeedY(-this.accelerator.speed.y)
		} else if (this.transform.position.y + this.height > canvas.clientHeight) {
			this.transform.position.y = canvas.clientHeight - this.height
			this.accelerator.setAccelerationY(-this.accelerator.acceleration.y)
			this.accelerator.setSpeedY(-this.accelerator.speed.y)
		}
	}
}