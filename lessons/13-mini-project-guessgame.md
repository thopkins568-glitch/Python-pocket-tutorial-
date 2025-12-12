---

## 📄 lessons/13-mini-project-guessgame.md
```markdown
# Mini-Project: Guessing Game

Combine input, loops, and conditionals to build a number guessing game.

Example:
```python
import random
secret = random.randint(1, 10)
while True:
    guess = int(input("Guess: "))
    if guess == secret:
        print("You win")
        break
    elif guess < secret:
        print("higher")
    else:
        print("lower")
