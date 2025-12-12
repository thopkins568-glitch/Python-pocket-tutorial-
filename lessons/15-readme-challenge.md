---

## 📄 lessons/15-readme-challenge.md
```markdown
# Readme Challenge

A small graded challenge: write a function that returns `True` if a string is a palindrome.

Example:
```python
def is_pal(s):
    s = "".join(ch for ch in s.lower() if ch.isalnum())
    return s == s[::-1]
print(is_pal("Racecar"))
