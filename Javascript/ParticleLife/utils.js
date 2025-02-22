class PositionHelper {
    static calculateAngleInRadiansBetweenPositions(start, end) {
        return this.calculateAngleInRadians(start.x, start.y, end.x, end.y)
    }

    static calculateAngleInRadians(x1, y1, x2, y2) {
        return Math.atan2(y1 - y2, x1 - x2)
    }

    static calculateAngleInDegrees(x1, y1, x2, y2) {
        return this.calculateAngleInDegrees(this.calculateAngleInRadians(x1, y1, x2, y2))
    }

    static calculateAngleInDegrees(directionAngleInDegrees) {
        return directionAngleInDegrees * (180 / Math.PI)
    }

    static calculateNewPositionWithDirectionPosition(positionInitial, direction, distance) {
        return this.calculateNewPositionWithDirectionAngle(positionInitial, this.calculateAngleInRadiansBetweenPositions(positionInitial, direction), distance)
    }

    static calculateNewPositionWithDirectionAngle(positionInitial, directionAngle, distance) {
        const distancePositions = this.calculateDistancePosition(directionAngle, distance)

        return new Vector2(
            positionInitial.x + distancePositions.x,
            positionInitial.x + distancePositions.y
        )
    }

    static calculateDistancePosition(directionAngle, distance) {
        return new Vector2(
            distance * Math.cos(directionAngle),
            distance * Math.sin(directionAngle)
        )
    }
}

class Vector2 {
    constructor(x = 0, y = 0) {
        this.x = x
        this.y = y
    }

    static zero() {
        return new Vector2(0, 0)
    }

    static distance(position1, position2) {
        const diference = Vector2.diference(position1, position2)
        return Math.sqrt((diference.x) ** 2 + (diference.y) ** 2)
    }

    static diference(position1, position2) {
        return new Vector2(
            position1.x - position2.x,
            position1.y - position2.y
        )
    }
}

class Transform {
    constructor(x = 0, y = 0) {
        this.position = new Vector2(x, y)
    }

    moveToDirection(direction, distance) {
        this.moveToPosition(PositionHelper.calculateNewPositionWithDirectionPosition(this.position, direction, distance))
    }

    moveToDirectionAngle(directionAngleRadians, distance) {
        this.moveToPosition(PositionHelper.calculateNewPositionWithDirectionAngle(this.position, directionAngleRadians, distance))
    }

    moveToPosition(position) {
        this.position.x += position.x
        this.position.y += position.y
    }
}

class Accelerator {
    constructor(transform = new Transform()) {
        this.transform = transform
        this.acceleration = Vector2.zero()
        this.speed = Vector2.zero()
    }

    update(deltaTime = 1) {
        this.speedUp(deltaTime)
        this.move(deltaTime)
    }

    speedUp(deltaTime = 1) {
        this.speed.x += this.acceleration.x * deltaTime
        this.speed.y += this.acceleration.y * deltaTime
    }

    move(deltaTime = 1) {
        this.transform.position.x += this.speed.x * deltaTime
        this.transform.position.y += this.speed.y * deltaTime
    }

    reset() {
        this.resetAcceleration()
        this.resetSpeed()
    }
    resetX() {
        this.acceleration.x = 0
        this.speed.x = 0
    }
    resetY() {
        this.acceleration.y = 0
        this.speed.y = 0
    }

    resetAcceleration() {
        this.acceleration.x = 0
        this.acceleration.y = 0
    }

    resetSpeed() {
        this.speed.x = 0
        this.speed.y = 0
    }

    accelerateTo(value) {
        this.acceleration.x += value.x
        this.acceleration.y += value.y
    }
    accelerateToX(value) {
        this.acceleration.x += value
    }
    accelerateToY(value) {
        this.acceleration.y += value
    }

    setAcceleration(value) {
        this.acceleration = value
    }
    setAccelerationX(value) {
        this.acceleration.x = value
    }
    setAccelerationY(value) {
        this.acceleration.y = value
    }

    speedUpTo(value) {
        this.speed.x += value.x
        this.speed.y += value.y
    }
    speedUpToX(value) {
        this.speed.x += value
    }
    speedUpToY(value) {
        this.speed.y += value
    }

    setSpeed(value) {
        this.speed = value
    }
    setSpeedX(value) {
        this.speed.x = value
    }
    setSpeedY(value) {
        this.speed.y = value
    }
}