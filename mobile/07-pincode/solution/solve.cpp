#include <iostream>
#include <string>
#include <vector>
#include <thread>
#include <mutex>
#include <iomanip>
#include <openssl/md5.h> // For MD5 calculation

// Function prototypes
std::string toHexString(const std::vector<unsigned char>& bytes);
bool checkPin(const std::string& pin);

// Mutex for synchronized output
std::mutex outputMutex;

// Worker function for each thread
void findPin(int startDigit) {
    for (int i = startDigit * 100000; i < (startDigit + 1) * 100000; i++) {
        std::string pin = std::to_string(i);
        while (pin.length() < 6) {
            pin = "0" + pin;
        }

        if (checkPin(pin)) {
            // Lock the output to avoid mixed output from threads
            std::lock_guard<std::mutex> lock(outputMutex);
            std::cout << "PIN is valid!" << std::endl;
            std::cout << "PIN: " << pin << std::endl;
            exit(0); // Exit all threads once the PIN is found
        }
    }
}

int main() {
    // Create 9 threads
    std::vector<std::thread> threads;

    for (int startDigit = 0; startDigit < 10; ++startDigit) {
        threads.emplace_back(findPin, startDigit);
    }

    // Join all threads
    for (auto& thread : threads) {
        thread.join();
    }

    return 0;
}

// Definitions for checkPin and toHexString go here
std::string toHexString(const std::vector<unsigned char>& bytes) {
    std::ostringstream hexStream;
    for (unsigned char b : bytes) {
        hexStream << std::hex << std::setfill('0') << std::setw(2) << (b & 0xFF);
    }
    return hexStream.str();
}

bool checkPin(const std::string& pin) {
    if (pin.length() != 6) {
        return false;
    }

    try {
        // Convert pin to byte array
        std::vector<unsigned char> pinBytes(pin.begin(), pin.end());

        for (int i = 0; i < 25; ++i) {
            for (int j = 0; j < 400; ++j) {
                // Initialize MD5 context
                unsigned char digest[MD5_DIGEST_LENGTH];
                MD5(pinBytes.data(), pinBytes.size(), digest);

                // Clone the MD5 digest result into pinBytes
                pinBytes.assign(digest, digest + MD5_DIGEST_LENGTH);
            }
        }

        // Convert the final digest to a hex string
        std::string hexString = toHexString(pinBytes);

        // Check if it matches the target hash
        if (hexString == "d04988522ddfed3133cc24fb6924eae9") {
            return true;
        }
        return false;
    } catch (const std::exception& e) {
        std::cerr << "Exception while checking pin: " << e.what() << std::endl;
        return false;
    }
}
