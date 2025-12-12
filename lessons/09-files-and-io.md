---

## 📄 lessons/09-files-and-io.md
```markdown
# Files & I/O

Open files with the `open()` function. Use `.read()`, `.readline()`, or read in a loop. Using `with` auto-closes the file.

Example:
```python
with open('/sdcard/sample.txt', 'w') as f:
    f.write('hello')
