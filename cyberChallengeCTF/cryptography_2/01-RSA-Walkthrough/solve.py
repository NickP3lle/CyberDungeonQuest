message = "This is the plaintext"

# convert message to int
m = int.from_bytes(message.encode(), "big")

print(f"m: {m}")
