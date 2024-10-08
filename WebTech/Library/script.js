const myLibrary = [];

class Book {
  constructor(title, author, pages, read) {
    this.title = title;
    this.author = author;
    this.pages = pages;
    this.read = read;
  }

  toggleReadStatus() {
    this.read = this.read === 'yes' ? 'no' : 'yes';
  }
}

function addBookToLibrary(book) {
  myLibrary.push(book);
  displayLibrary();
}

function displayLibrary() {
  const libraryDiv = document.getElementById('library');
  libraryDiv.innerHTML = ''; // Clear previous library display

  myLibrary.forEach((book, index) => {
    const bookCard = document.createElement('div');
    bookCard.classList.add('book-card');

    const bookTitle = document.createElement('h3');
    bookTitle.textContent = book.title;
    bookCard.appendChild(bookTitle);

    const bookAuthor = document.createElement('p');
    bookAuthor.textContent = `Author: ${book.author}`;
    bookCard.appendChild(bookAuthor);

    const bookPages = document.createElement('p');
    bookPages.textContent = `Pages: ${book.pages}`;
    bookCard.appendChild(bookPages);

    const bookRead = document.createElement('p');
    bookRead.textContent = `Read: ${book.read}`;
    bookCard.appendChild(bookRead);

    // Toggle read status button
    const toggleReadBtn = document.createElement('button');
    toggleReadBtn.textContent = 'Toggle Read';
    toggleReadBtn.addEventListener('click', () => {
      book.toggleReadStatus();
      displayLibrary();
    });
    bookCard.appendChild(toggleReadBtn);

    // Remove book button
    const removeBtn = document.createElement('button');
    removeBtn.textContent = 'Remove';
    removeBtn.classList.add('remove-btn');
    removeBtn.addEventListener('click', () => {
      myLibrary.splice(index, 1);
      displayLibrary();
    });
    bookCard.appendChild(removeBtn);

    libraryDiv.appendChild(bookCard);
  });
}

// Form submission handling
document.getElementById('book-form').addEventListener('submit', (e) => {
  e.preventDefault();

  const title = document.getElementById('title').value;
  const author = document.getElementById('author').value;
  const pages = document.getElementById('pages').value;
  const read = document.getElementById('read-status').value;

  const newBook = new Book(title, author, pages, read);
  addBookToLibrary(newBook);

  // Close modal and reset form
  document.getElementById('book-form-modal').style.display = 'none';
  document.getElementById('book-form').reset();
});

// New book button to open form modal
document.getElementById('new-book-btn').addEventListener('click', () => {
  document.getElementById('book-form-modal').style.display = 'flex';
});

// Cancel button to close form modal
document.getElementById('cancel-btn').addEventListener('click', () => {
  document.getElementById('book-form-modal').style.display = 'none';
});
