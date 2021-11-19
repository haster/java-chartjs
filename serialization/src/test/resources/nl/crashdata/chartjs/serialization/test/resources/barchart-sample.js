{
  type: "bar",
  data: {
    labels: [ "January", "February", "March", "April", "May", "June", "July"],
    datasets: [
      {
        label: "Dataset 1",
        data: [10, 15, -1, 24, 31, -4, 3],
        borderColor: ["rgba(255, 99, 132, 1.0)"],
        backgroundColor: ["rgba(255, 99, 132, 0.5)"]
      },
      {
        label: "Dataset 2",
        data: [11, 2, 34, -17, -22, 13, 0],
        borderColor: ["rgba(54, 162, 235, 1.0)"],
        backgroundColor: ["rgba(54, 162, 235, 0.5)"]
      }
    ]
  },
  options: {
    responsive: true,
    plugins: {
      legend: {
      	display: true,
        position: "top"
      },
      title: {
        display: true,
        text: ["Chart.js Bar Chart"]
      }
    }
  }
}