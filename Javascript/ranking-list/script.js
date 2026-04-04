const users = {}

const a = Math.round(Math.random() * 50) + 50

for(let i = 0; i < a; i++) {
	users[i + 1] = {
		id: i + 1,
		points: Math.round(Math.random() * 100)
	}
}

console.log(users)

function rankear() {
	const ranking = []
	const VALID_ID = (id) => {
		for(let i = 0; i < ranking.length; i++) {
			if (ranking[i].id == id) {
				return false
			}
		}
		return true
	}
	const CHOISE_BEST = (id, i) => {
		let best = id
		if (VALID_ID(best)) {
			Object.keys(users).map((j) => {
				if (j > i) {
					if (users[best].points < users[j].points) {
						if (VALID_ID(users[j].id)) {
							best = users[j].id
						}
					}
				}
			})
			ranking.push({colocation: ranking.length + 1, id: best, points: users[best].points})
		} else {
			best = null
		}
		return best
	}

	Object.keys(users).map((i) => {
		let best
		do {
			best = CHOISE_BEST(users[i].id, i)
		} while (best != users[i].id && best != null)
	})

	return ranking
}

console.log(rankear())
