---

## 📄 lessons/10-errors-and-exceptions.md
```markdown
# Errors & Exceptions

Handle runtime errors using `try` and `except`. Catching specific error types is better practice.

Example:
```python
try:
    x = int("a")
except ValueError:
    print("not an int")
