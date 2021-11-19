{
  type: "bar",
  data: {
    labels: [ "January", "February", "March", "April", "May", "June", "July"],
    datasets: [
      {
        label: "Dataset 1",
        data: [-89, -88, -86, -82, -76, -55, -41],
        borderColor: ["rgba(255, 99, 132, 1.0)"],
        backgroundColor: ["rgba(255, 99, 132, 0.5)"]
      },
      {
        label: "Dataset 2",
        data: [-59, -56, -15, 23, 24, 93, 95],
        borderColor: ["rgba(54, 162, 235, 1.0)"],
        backgroundColor: ["rgba(54, 162, 235, 0.5)"]
      }
    ]
  },
  options: {
    indexAxis: "y",
    elements: {
      bar: {
        borderWidth: 2
        }
      },
    responsive: true,
    plugins: {
      legend: {
        display: true,
        position: "right"
        },
      title: {
        display: true,
        text: ["Chart.js Horizontal Bar Chart"]
        }
      }
  }
}