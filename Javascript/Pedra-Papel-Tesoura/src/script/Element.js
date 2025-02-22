export default class Element {
    static speed = .1

    constructor(position, dimension, typeEl, code, target) {
        this.position = position
        this.dimension = dimension
        this.typeEl = typeEl
        this.code = code
        this.target = target
        this.findTarget()
    }

    draw(ctx) {
        let color = ""

        switch (this.typeEl) {
            case 1:
                color = "#000"
                break;
            case 2:
                color = "#ff0000"
                break;
            case 3:
                color = "#0000ff"
                break;
        }

        ctx.fillStyle = color
        ctx.fillRect(this.position.x, this.position.y, this.dimension.width, this.dimension.height)
    }

    update() {
        if (this.target.x < this.position.x) this.position.x -= Element.speed
        else if (this.target.x > this.position.x) this.position.x += Element.speed
        if (this.target.y < this.position.y) this.position.y -= Element.speed
        else if (this.target.y > this.position.y) this.position.y += Element.speed
    }

    findTarget(elements, lengthEls) {
        let nowTarget = this.target

        for (let i = 0; i < lengthEls; i++) {
            if (elements[i].code == this.code && elements[i].typeEl == this.typeEl) continue

            let this_pos = this.position
            let nowTarget_pos = nowTarget
            let enemy_pos = elements[i].position

            if (this.target.x < this.position.x) {
                if (this.target.y < this.position.y) {
                    this_pos = {
                        x: this.position.x + this.dimension.width,
                        y: this.position.y + this.dimension.height,
                    }
                    nowTarget_pos = {
                        x: nowTarget.x,
                        y: nowTarget.y,
                    }
                    enemy_pos = {
                        x: elements[i].position.x,
                        y: elements[i].position.y,
                    }
                } else if (this.target.y > this.position.y) {
                    this_pos = {
                        x: this.position.x + this.dimension.width,
                        y: this.position.y,
                    }
                    nowTarget_pos = {
                        x: nowTarget.x,
                        y: nowTarget.y + this.dimension.height,
                    }
                    enemy_pos = {
                        x: elements[i].position.x,
                        y: elements[i].position.y + elements[i].dimension.height,
                    }
                }
            } else if (this.target.x > this.position.x) {
                if (this.target.y < this.position.y) {
                    this_pos = {
                        x: this.position.x,
                        y: this.position.y,
                    }
                    nowTarget_pos = {
                        x: nowTarget.x + this.dimension.width,
                        y: nowTarget.y + this.dimension.height,
                    }
                    enemy_pos = {
                        x: elements[i].position.x + elements[i].dimension.width,
                        y: elements[i].position.y + elements[i].dimension.height,
                    }
                } else if (this.target.y > this.position.y) {
                    this_pos = {
                        x: this.position.x,
                        y: this.position.y + this.dimension.height,
                    }
                    nowTarget_pos = {
                        x: nowTarget.x + this.dimension.width,
                        y: nowTarget.y,
                    }
                    enemy_pos = {
                        x: elements[i].position.x + elements[i].dimension.width,
                        y: elements[i].position.y,
                    }
                }
            }

            if ((Math.abs(this_pos.x - enemy_pos.x) < Math.abs(this_pos.x - nowTarget_pos.x)) &&
                (Math.abs(this_pos.y - enemy_pos.y) < Math.abs(this_pos.y - nowTarget_pos.y))) {
                nowTarget = elements[i].position
            }
        }

        this.target = nowTarget
    }
}
