class Game:
    def __init__(self, input: str):
        input = input.strip()
        self.id = int(input.split(":")[0].split(" ")[1])
        self.values = {"red": [], "green": [], "blue": []}

        for roll in input.split(": ")[1].split(";"):
            for pull in roll.split(", "):
                pull = pull.strip()
                self.values[pull.split(" ")[1]].append(int(pull.split(" ")[0]))

    def get_max_reds(self): # Returns 0 if no red
        return max(self.values.get("red", [0]))
    
    def get_max_greens(self): # Returns 0 if no green
        return max(self.values.get("green", [0]))
    
    def get_max_blues(self): # Returns 0 if no blue
        return max(self.values.get("blue", [0]))

    def get_cube_power(self):
        total = 1

        if self.get_max_reds() > 0:
            total *= self.get_max_reds()

        if self.get_max_blues() > 0:
            total *= self.get_max_blues()

        if self.get_max_greens() > 0:
            total *= self.get_max_greens() 

        return total 

    def ensure_possibility(self, red_max: int, green_max: int, blue_max: int):
        return self.get_max_reds() <= red_max and self.get_max_greens() <= green_max and self.get_max_blues() <= blue_max
