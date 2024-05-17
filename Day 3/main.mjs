import fs from "node:fs";

function checkIndexForSymbol(i, j, data) {
    // Assumes data has values at the provided indices

    // i -> int
    // j -> int
    // data -> array[string]

    const value = data[i][j];

    if (!isNaN(value)) {
        return false; // If the value is a number
    }

    if (value === ".") {
        return false; // If the value is a period
    }

    return true; // Otherwise, true
}

function getAdjacentIndices(i, jstart, jend, data) {
    // Will check surround indices for existance, if they exist
    // Checks returns an array of pairs of numbers, containing every
    // i and j around the selection provided

    // i -> int : line number
    // jstart -> int : starting index
    // jend -> int : ending index
    // data -> array[string]

    for (let k = i - 1; k < i + 1; k++) {
        for (let l = jstart - 1; l < jend + 1; l++) {

        }
    }
}

function checkIndicesExist(i, j, data) {
    // Checks if the indices would be valid in the array of strings

    // i -> int
    // j -> int
    // data -> array[string]

    let iLeftBound = 0;
    let iRightBound = data.length - 1;

    let jLeftBound = 0;
    let jRightBound = data[0].length - 1;

    return iLeftBound <= i && i <= iRightBound && jLeftBound <= j && j <= jRightBound;
}

fs.readFile("sample_input.txt", "utf8", (err, data) => {
    if (err) {
        console.error(err);
        return;
    }

    const lines = data.split("\n");

    for (let i = 0; i < lines.length; i++) {
        for (let j = 0; j < lines[0].length; j++) {
            // do something
        }

        console.log(lines[i]);
    }
})
