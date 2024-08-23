# AILA (Artificial Intelligence Legal Assistance)

## Frontend

AILA is an Android app developed using Kotlin and Jetpack Compose. The app provides a user-friendly interface to interact with the backend server and view summarized legal case documents.

### Features

- **Modern UI**: Built using Jetpack Compose for a responsive and dynamic user interface.
- **Document Querying**: Allows users to input queries and retrieve relevant legal case documents.
- **Document Summarization**: Displays concise summaries of legal documents.
- **Smooth Navigation**: Uses Jetpack Navigation for seamless transitions between screens.

### Technologies Used

- **Kotlin**: The programming language used for Android app development.
- **Jetpack Compose**: A modern toolkit for building native UIs in Android.
- **Retrofit**: For making network requests to the backend server.
- **ViewModel**: Manages UI-related data in a lifecycle-conscious way.
- **LiveData**: Provides a way to observe data changes in the UI.

### Setup Instructions

#### Prerequisites

- Android Studio with the latest version of Kotlin and Jetpack Compose.
- An active internet connection for making API requests.

#### Installation

1. **Clone the repository:**

    ```bash
    git clone https://github.com/ekansh1002/AILA-Artificial-Intelligence-Legal-Assistance-App.git
    cd AILA-Artificial-Intelligence-Legal-Assistance-App
    ```

2. **Open the project in Android Studio:**

    Open Android Studio and import the project by selecting "Open an existing project" and navigating to the cloned directory.

3. **Sync Gradle:**

    Click "Sync Project with Gradle Files" to ensure all dependencies are correctly resolved.

4. **Configure Network Access:**

    Update the base URL in your Retrofit configuration to point to the backend server. For example:

    ```kotlin
    object RetrofitClient {
        private const val BASE_URL = "http://127.0.0.1:5000/"
        // Rest of the configuration
    }
    ```

5. **Run the App:**

    Use Android Studio's built-in tools to build and run the app on an emulator or physical device.

## Backend

This is a backend server that processes and summarizes legal case documents using Natural Language Processing (NLP) models like BERT and BART. The server can be accessed via a `curl` command or Postman to query and retrieve summaries of the most relevant documents based on a given query. This can be run seperately from the Android App interface.

### Features

- **Query Legal Documents**: Retrieve the most relevant legal case documents based on a query.
- **Document Summarization**: Generate concise summaries of the retrieved documents.
- **Preprocessing**: Text preprocessing and tokenization using BERT.
- **Similarity Matching**: Use cosine similarity to find the most relevant documents.

### Technologies Used

- **Flask**: A lightweight WSGI web application framework for Python.
- **PyTorch**: An open-source machine learning framework for NLP model inference.
- **BERT**: A transformer-based model for text preprocessing and embedding generation.
- **BART**: A transformer model for text summarization.
- **NLTK**: Natural Language Toolkit for tokenization and stemming.
- **Scikit-Learn**: Used for calculating cosine similarity between query and document embeddings.

### Setup Instructions

#### Prerequisites

- Python 3.8 or higher
- Pip package manager
- `virtualenv`

#### Installation

1. **Clone the repository:**

    ```bash
    git clone https://github.com/ekansh1002/AILA-Artificial-Intelligence-Legal-Assistance-App.git
    cd AILA-Artificial-Intelligence-Legal-Assistance-App
    cd flask_app
    ```

2. **Create a virtual environment:**

    ```bash
    python3 -m venv venv
    source venv/bin/activate 
    ```

3. **Install the required packages:**

    ```bash
    pip install -r requirements.txt
    ```

4. **Ensure your legal case documents are placed in the specified directory:**

    Update the `directory` variable in the script to point to your document folder:

    ```python
    directory = r"C:\path\to\your\documents"
    ```

### Running the Server

1. **Start the Flask server:**

    ```bash
    python app.py
    ```

2. The server will start running on `http://127.0.0.1:5000/`.

### Making Requests

You can interact with the server using `curl` or Postman.

#### Example `curl` Command

```bash
curl -X POST http://127.0.0.1:5000/query -H "Content-Type: application/json" -d '{"query": "Your legal query here"}'

