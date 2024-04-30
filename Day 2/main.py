from game import Game

def main():
    part_1()
    part_2()

def part_1():
    with open("input.txt") as f:
        total = 0
        for line in f:
            current_game = Game(line)
            if current_game.ensure_possibility(12, 13, 14):
                total += current_game.id

        print(f"Part 1: {total}")

def part_2():
    with open("input.txt") as f:
        total = 0
        for line in f:
            current_game = Game(line)
            total += current_game.get_cube_power()

        print(f"Part 2: {total}")

if __name__ == "__main__":
    main()
