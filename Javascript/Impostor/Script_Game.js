const canvas = document.getElementById('canvas');

if (innerHeight < 500) {
    canvas.width = innerHeight;
    canvas.height = innerHeight;
} else {
    canvas.width = 500;
    canvas.height = 500;
}

const ctx = canvas.getContext("2d");