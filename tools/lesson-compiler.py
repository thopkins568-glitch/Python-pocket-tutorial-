#!/usr/bin/env python3
"""
Simple lesson compiler: turns lessons/*.md into JSON files for app assets.
This is intentionally minimal — replace with a robust parser as needed.
"""
import os
import json
import re

SRC = "lessons"
DST = "app/src/main/assets/lessons"

os.makedirs(DST, exist_ok=True)

def parse_md(path):
    with open(path, 'r', encoding='utf-8') as f:
        text = f.read().strip()
    # naive split: first line title, then content. code blocks fenced by ``` are examples.
    lines = text.splitlines()
    title = lines[0].lstrip('# ').strip() if lines else os.path.basename(path)
    body = "\n".join(lines[1:]).strip()
    parts = re.split(r"```(?:python)?", body)
    # parts: [intro, example, rest?] we choose example as first code block
    intro = parts[0].strip() if parts else ""
    example = parts[1].strip() if len(parts) > 1 else ""
    starter_code = example
    return {
        "id": os.path.basename(path).replace(".md", ""),
        "title": title,
        "level": "beginner",
        "text": intro,
        "example": example,
        "starter_code": starter_code
    }

def main():
    files = sorted([f for f in os.listdir(SRC) if f.endswith('.md')])
    for fname in files:
        src = os.path.join(SRC, fname)
        data = parse_md(src)
        out = os.path.join(DST, fname.replace('.md', '.json'))
        with open(out, 'w', encoding='utf-8') as f:
            json.dump(data, f, indent=2)
        print("Wrote", out)

if __name__ == "__main__":
    main()
