class Game:
    def __init__(self, input: str):
        input = input.strip()
        self.id = int(input.split(":")[0].split(" ")[1])
        self.values = {"red": [], "green": [], "blue": []}

        for roll in input.split(": ")[1].split(";"):
            for pull in roll.split(", "):
                pull = pull.strip()
                self.values[pull.split(" ")[1]].append(int(pull.split(" ")[0]))

    def ensure_possibility(self, red_max: int, green_max: int, blue_max: int):
        return max(self.values.get("red", [0])) <= red_max and max(self.values.get("green", [0])) <= green_max and max(self.values.get("blue", [0])) <= blue_max
