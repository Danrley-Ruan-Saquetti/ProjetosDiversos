export function resetDebug(name: string) {
  const staticDebug = (debugIf as any)

  staticDebug[name] = 0
}

export function debugIf(name: string, statement: boolean, times?: number) {
  if (!statement) {
    return
  }

  if (times) {
    const staticDebug = (debugIf as any)

    if (staticDebug[name] === undefined) {
      staticDebug[name] = 0
    }

    if (staticDebug[name] > times) {
      return
    }

    staticDebug[name]++
  }

  debugger
}
