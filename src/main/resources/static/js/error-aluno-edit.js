(() => {
  'use strict'

  // Function to display alerts
  const alertPlaceholder = document.getElementById('liveAlertPlaceholder')
  const appendAlert = (message, type) => {
    const wrapper = document.createElement('div')
    wrapper.innerHTML = [
      `<div class="alert alert-${type} alert-dismissible" role="alert">`,
      `   <div>${message}</div>`,
      '   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>',
      '</div>'
    ].join('')

    alertPlaceholder.append(wrapper)
  }

  // Handle form submission
  const form = document.querySelector('.needs-validation')
  form.addEventListener('submit', event => {
    event.preventDefault()
    event.stopPropagation()

    // Collect form data
    const formData = new FormData(form)

    // Send data using fetch API
    fetch(form.action, {
      method: form.method,
      body: formData,
    })
    .then(response => {
      if (response.ok) {
              appendAlert('Aluno editado com sucesso!', 'success') // Alert de sucesso
            } else {
              appendAlert('Houve um problema ao editar o aluno. Verifique se o e-mail ou telefone já está em uso.', 'danger')
            }
    })
    .catch(error => {
      console.error('Error:', error)
      appendAlert('Houve um problema no envio do formulário.', 'danger')
    })
  })
})()
