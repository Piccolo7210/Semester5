// Gameboard Module (IIFE)
const Gameboard = (() => {
    let board = ["", "", "", "", "", "", "", "", ""]; // 9 empty spots
  
    const getBoard = () => board;
    
    const resetBoard = () => {
      board = ["", "", "", "", "", "", "", "", ""];
    };
    
    const setMark = (index, mark) => {
      if (board[index] === "") {
        board[index] = mark;
        return true;
      }
      return false;
    };
  
    const render = () => {
      const gameboardDiv = document.getElementById("gameboard");
      gameboardDiv.innerHTML = ""; // Clear board display
      board.forEach((mark, index) => {
        const cell = document.createElement("div");
        cell.classList.add("cell");
        cell.dataset.index = index;
        cell.innerHTML = `<span>${mark}</span>`;
        gameboardDiv.appendChild(cell);
      });
    };
  
    return { getBoard, setMark, resetBoard, render };
  })();
  
  // Player Factory Function
  const Player = (name, mark) => {
    return { name, mark };
  };
  
  // Game Controller Module
  const GameController = (() => {
    let player1, player2;
    let currentPlayer;
    let gameOver = false;
  
    const startGame = () => {
      const player1Name = document.getElementById("player1-name").value || "Player 1";
      const player2Name = document.getElementById("player2-name").value || "Player 2";
      
      player1 = Player(player1Name, "X");
      player2 = Player(player2Name, "O");
      currentPlayer = player1;
      
      gameOver = false;
      Gameboard.resetBoard();
      Gameboard.render();
      updateGameStatus();
    };
  
    const updateGameStatus = (message = `${currentPlayer.name}'s turn`) => {
      document.getElementById("game-status").textContent = message;
    };
  
    const switchPlayer = () => {
      currentPlayer = currentPlayer === player1 ? player2 : player1;
      updateGameStatus();
    };
  
    const checkWinner = () => {
      const board = Gameboard.getBoard();
      const winningCombos = [
        [0, 1, 2], [3, 4, 5], [6, 7, 8], // Rows
        [0, 3, 6], [1, 4, 7], [2, 5, 8], // Columns
        [0, 4, 8], [2, 4, 6],            // Diagonals
      ];
  
      for (let combo of winningCombos) {
        const [a, b, c] = combo;
        if (board[a] && board[a] === board[b] && board[a] === board[c]) {
          return board[a]; // Return winning mark (X or O)
        }
      }
  
      return board.includes("") ? null : "tie"; // Check for tie
    };
  
    const handleClick = (e) => {
      if (gameOver) return;
  
      const index = e.target.dataset.index;
      if (Gameboard.setMark(index, currentPlayer.mark)) {
        Gameboard.render();
        const winner = checkWinner();
        if (winner) {
          gameOver = true;
          updateGameStatus(winner === "tie" ? "It's a tie!" : `${currentPlayer.name} wins!`);
          document.getElementById("restart-game").classList.remove("hidden");
        } else {
          switchPlayer();
        }
      }
    };
  
    const restartGame = () => {
      startGame();
      document.getElementById("restart-game").classList.add("hidden");
    };
  
    return { startGame, handleClick, restartGame };
  })();
  
  // Event Listeners
  document.getElementById("start-game").addEventListener("click", GameController.startGame);
  document.getElementById("gameboard").addEventListener("click", GameController.handleClick);
  document.getElementById("restart-game").addEventListener("click", GameController.restartGame);
  