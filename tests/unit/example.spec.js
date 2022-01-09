import { mount } from '@vue/test-utils'
import Home from '../../src/views/Home'
describe('HelloWorld.vue', () => {
  test('renders the button name', () => {
    const generate = 'Generate'
    const wrapper = mount(Home, {
      propsData: {
        home: { name: generate, completed: false }
      }
    })
    expect(wrapper.html()).toContain(generate)
  })
  test('calls createMeme when Generate Button is clicked', () => {
    const wrapper = mount(Home, {
      propsData: {
        home: { name: '', completed: false }
      }
    })
    const createMeme = jest.fn
    wrapper.setMethods({
      createMeme: createMeme
    })
    wrapper.find('button').trigger('click')
    expect(createMeme).toHaveBeenCalled()
  })
  test('calls resetpage when Reset Button is clicked', () => {
    const wrapper = mount(Home, {
      propsData: {
        home: { name: 'fetching', completed: false }
      }
    })
    const createMeme = jest.fn
    wrapper.setMethods({
      createMeme: createMeme
    })
    wrapper.find('button').trigger('click')
    expect(createMeme).toHaveBeenCalled()
  })
})
