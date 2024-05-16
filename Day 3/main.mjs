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
    // i -> int
    // jstart -> int : starting index
    // jend -> int : ending index
    // data -> array[string]

    // Implement
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
