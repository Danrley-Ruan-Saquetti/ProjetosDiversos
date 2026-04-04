export class Mathf {

  static clamp01(value: number) {
    return Mathf.clamp(value, 0, 1)
  }

  static clamp(value: number, min: number, max: number) {
    if (value < min) {
      return min
    }
    if (value > max) {
      return max
    }
    return value
  }

  static lerp(from: number, to: number, delta: number) {
    return from + (to - from) * delta
  }
}
