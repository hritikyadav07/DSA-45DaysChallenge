# https://www.geeksforgeeks.org/rabin-karp-algorithm-for-pattern-searching/

def rabin_karp(text, pattern, q=101):
    m = len(pattern)
    n = len(text)
    b = 256  # Number of characters in the input alphabet (e.g., ASCII)
    h = 1
    p_hash = 0
    t_hash = 0
    

    # hash = (hash - (text[i - pattern_length] * (b^(pattern_length - 1))) % p) * b + text[i]

    # Precompute (b^(m-1)) % q
    for i in range(m-1):
        h = (h * b) % q
    
    # Compute the hash value of pattern and first window of text
    for i in range(m):
        p_hash = (b * p_hash + ord(pattern[i])) % q
        t_hash = (b * t_hash + ord(text[i])) % q
    
    # Slide the pattern over text one by one
    for i in range(n - m + 1):
        # Check the hash values
        if p_hash == t_hash:
            # Check the characters
            if text[i:i+m] == pattern:
                print(f"Pattern found at index {i}")
        
        # Calculate hash value for next window of text
        if i < n - m:
            t_hash = (b * (t_hash - ord(text[i]) * h) + ord(text[i + m])) % q
            # We might get negative value of t_hash, converting it to positive
            if t_hash < 0:
                t_hash = t_hash + q

# Example usage
text = "GEEKS FOR GEEKS"
pattern = "GEEK"
rabin_karp(text, pattern)
