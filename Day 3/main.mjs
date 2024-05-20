import fs from "node:fs";

function getNumberIndicesFromLine(line) {
    // Returns an array of all the indices in a string that contain numbers
    // line -> string

    let result = [];

    for (let i = 0; i < line.length; i++) {
        if (!isNaN(line[i])) {
            result.push(i);
        }
    }

    return result;
}

function separateNumberIndices(numberIndices) {
    if (numberIndices.length === 0) {
        return [];
    }

    let result = [];
    let subArray = [numberIndices[0]];

    for (let i = 1; i < numberIndices.length; i++) {
        if (numberIndices[i] === numberIndices[i - 1] + 1) {
            subArray.push(numberIndices[i]);
        } else {
            result.push(subArray);
            subArray = [numberIndices[i]];
        }
    }

    result.push(subArray);
    return result;
}


function part1() {
    fs.readFile("sample_input.txt", "utf8", (err, data) => {
        if (err) {
            console.error(err);
            return;
        }
    
        const lines = data.split("\n");
    
        let lineNumber = 0;
        lines.forEach((line) => {
            let numberIndices = getNumberIndicesFromLine(line);
            console.log(separateNumberIndices(numberIndices));
            lineNumber++;
        })
    })
}

function main() {
    part1();
}

main();
