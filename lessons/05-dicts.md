---

## 📄 lessons/05-dicts.md
```markdown
# Dictionaries (dict)

Dictionaries map **keys** to **values**. Use `dict[key]` to get a value or `.get(key, default)` for safety.

Example:
```python
d = {'a': 1, 'b': 2}
for key, value in d.items():
    print(key, value)
