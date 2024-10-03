import base64
import string


def encrypt(clear, key):
    enc = []
    for i in range(len(clear)):
        key_c = key[i % len(key)]
        enc_c = chr((ord(clear[i]) + ord(key_c)) % 128)
        enc.append(enc_c)
    return str(base64.urlsafe_b64encode("".join(enc).encode('ascii')), 'ascii')


# def split_into_chunks(string, chunk_size):
#     return [string[i:i+chunk_size] for i in range(0, len(string), chunk_size)]


m = "See you later in the city center"
# list = split_into_chunks(m, 4)
c = "QSldSTQ7HkpIJj9cQBY3VUhbQ01HXD9VRBVYSkE6UWRQS0NHRVE3VUQrTDE="
# See
# QSldSTQ+5
# m = "See "
# c = "QSldSTQ"


for i in range(97, 123):
    print(f"i: {chr(i)}")
    for j in range(97, 123):
        print(f"j: {chr(j)}")
        for k in range(97, 123):
            print(f"k: {chr(k)}")
            for l in range(97, 123):
                key1 = chr(i) + chr(j) + chr(k) + chr(l)
                d = encrypt(m, key1)
                for w in range(97, 123):
                    for x in range(97, 123):
                        for y in range(97, 123):
                            for z in range(97, 123):
                                key2 = chr(w) + chr(x) + chr(y) + chr(z)
                                if encrypt(d, key2) == c:
                                    print("Key1:", key1)
                                    print("Key2:", key2)
                                    exit()
