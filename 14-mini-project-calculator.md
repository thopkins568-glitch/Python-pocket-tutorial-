---

## 📄 lessons/14-mini-project-calculator.md
```markdown
# Mini-Project: Simple Calculator

Parse a simple expression like `"3 + 4"` and compute the result.

Example:
```python
expr = input("Expr: ")
parts = expr.split()
if len(parts) == 3:
    a, op, b = parts
    a = float(a); b = float(b)
    if op == "+":
        print(a + b)
    elif op == "-":
        print(a - b)
    elif op == "*":
        print(a * b)
    elif op == "/":
        print(a / b)
