import numpy as np
from PIL import Image

enc1 = Image.open("flag_enc.png")
enc2 = Image.open("notflag_enc.png")

enc1np = np.array(enc1)
enc2np = np.array(enc2)

xor_result = np.bitwise_xor(enc1np, enc2np)
key = np.bitwise_xor(enc1np, xor_result)

key_image = Image.fromarray(key.astype(np.uint8))
key_image.save("key.png")

original_img1 = np.bitwise_xor(enc1np, key)
original_img1_image = Image.fromarray(original_img1.astype(np.uint8))
original_img1_image.save("img1.png")

original_img2 = np.bitwise_xor(enc2np, key)
original_img2_image = Image.fromarray(original_img2.astype(np.uint8))
original_img2_image.save("img2.png")
