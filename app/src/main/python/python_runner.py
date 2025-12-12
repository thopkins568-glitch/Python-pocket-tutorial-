# Minimal runner used by Chaquopy
import sys
import io

def run_snippet(code: str) -> str:
    """Execute code in a restricted environment and return stdout/stderr as string."""
    old_stdout = sys.stdout
    old_stderr = sys.stderr
    sys.stdout = io.StringIO()
    sys.stderr = io.StringIO()
    # Restrict builtins -- minimal sandbox
    safe_builtins = {
        'print': print,
        'range': range,
        'len': len,
        'int': int,
        'float': float,
        'str': str,
        'input': input,  # input will raise EOFError if not provided
        'min': min, 'max': max, 'abs': abs,
        'sum': sum, 'enumerate': enumerate, 'zip': zip, 'sorted': sorted,
        # add more as needed
    }
    globs = {"__builtins__": safe_builtins}
    try:
        # execute
        exec(code, globs, globs)
        out = sys.stdout.getvalue()
        errs = sys.stderr.getvalue()
        return out + (("\nERR:\n" + errs) if errs else "")
    except Exception as e:
        return "ERROR: " + str(e)
    finally:
        sys.stdout = old_stdout
        sys.stderr = old_stderr
