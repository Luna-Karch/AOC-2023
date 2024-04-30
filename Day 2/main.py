from game import Game

def main():
    part_1()

def part_1():
    with open("input.txt") as f:
        total = 0
        for line in f:
            current_game = Game(line)
            if current_game.ensure_possibility(12, 13, 14):
                total += current_game.id

        print(f"Part 1: {total}")

if __name__ == "__main__":
    main()
