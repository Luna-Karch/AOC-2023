import fs from "node:fs";

fs.readFile("sample_input.txt", "utf8", (err, data) => {
    if (err) {
        console.error(err);
        return;
    }

    console.log(data); // Print out the file
})